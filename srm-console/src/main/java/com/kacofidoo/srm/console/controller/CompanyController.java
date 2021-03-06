/**
 * 
 */
package com.kacofidoo.srm.console.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kacofidoo.srm.common.exception.SrmException;
import com.kacofidoo.srm.common.utils.JsonUtils;
import com.kacofidoo.srm.console.service.CompanyService;
import com.kacofidoo.srm.console.vo.AjaxResponse;
import com.kacofidoo.srm.orm.entity.Company;

/**
 * @author Jeff.Tsai
 * 
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
	private static final Log log = LogFactory.getLog(CompanyController.class);

	@Inject
	private CompanyService companyService;

	@RequestMapping("/apply")
	public void apply() {
	}

	@RequestMapping("/validate")
	public void validate(String companyName, HttpServletResponse response) throws SrmException, IOException {
		boolean isExist = companyService.exist(companyName);
		PrintWriter writer = response.getWriter();
		AjaxResponse ar = isExist ? AjaxResponse.failed() : AjaxResponse.success();
		writer.write(ar.toString());
		IOUtils.closeQuietly(writer);
	}

	@RequestMapping("/register")
	public void register(Company company, HttpServletResponse response) {
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			this.companyService.register(company);
			writer.write(AjaxResponse.success().toString());
		} catch (Exception e) {
			e.printStackTrace();
			if (log.isErrorEnabled()) {
				log.error("register company " + JsonUtils.toJson(company) + " error: ", e);
			}
		}
	}
}
