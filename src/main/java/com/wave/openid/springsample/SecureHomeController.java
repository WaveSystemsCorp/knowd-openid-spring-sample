package com.wave.openid.springsample;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Secure home controller.
 * Spring-security directs clients to this controller when user was authenticated and has role 'ROLE_USER'
 */
public class SecureHomeController
        extends AbstractController
{
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest req,
                                                 HttpServletResponse res)
            throws
            Exception
    {
        ModelAndView mav = new ModelAndView("secure/index");

        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null && auth.getPrincipal() != null && auth.getPrincipal() instanceof User)
            {
                User user = (User)auth.getPrincipal();
                mav.addObject("user", user);
                if (auth instanceof OpenIDAuthenticationToken)
                {
                    OpenIDAuthenticationToken token = (OpenIDAuthenticationToken)auth;
                    if (token.getAttributes() != null)
                    {
                        for (OpenIDAttribute openIDAttribute : token.getAttributes())
                        {
                            if (openIDAttribute.getName().equalsIgnoreCase("trustScore") &&
                                    openIDAttribute.getValues() != null)
                            {
                                mav.addObject("trustScore", openIDAttribute.getValues().get(0));
                            }
                            else
                            if (openIDAttribute.getName().equalsIgnoreCase("needsSetup") &&
                                    openIDAttribute.getValues() != null)
                            {
                                mav.addObject("needsSetup", openIDAttribute.getValues().get(0));
                            }
                            else
                            if (openIDAttribute.getName().equalsIgnoreCase("setupURL") &&
                                    openIDAttribute.getValues() != null)
                            {
                                mav.addObject("setupURL", openIDAttribute.getValues().get(0));
                            }
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mav;
    }
}
