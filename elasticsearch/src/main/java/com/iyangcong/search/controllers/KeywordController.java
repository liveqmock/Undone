package com.iyangcong.search.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyangcong.search.services.KeywordService;
import com.iyangcong.search.utilities.PageHelper;

@Controller
@RequestMapping("/keyword")
public class KeywordController {

	private static final Logger logger = LoggerFactory
			.getLogger(KeywordController.class);

	@Autowired
	private KeywordService keywordService;

	@ResponseBody
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Object search(@RequestParam(value = "keywords") String keywords,
			@RequestParam(value = "page") String page,
			@RequestParam(value = "size", required = false) String size) {
		if (logger.isDebugEnabled()) {
			logger.debug("--search--");
		}
		return keywordService.searchByKeywords(keywords,
				PageHelper.generatePageable(page, size));
	}

}
