package com.yushunbank.foreignexchangecenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yushunbank.foreignexchangecenter.model.ForeignExchangeRate;
import com.yushunbank.foreignexchangecenter.service.RateService;

@Controller
public class ForeignExchangeRateViewController {
	@Autowired
	private RateService rateService ;
	
	@RequestMapping("/")
	public String viewRatePage(Model model) {
		List<ForeignExchangeRate> listRates = rateService.getAllRates();
		model.addAttribute("listRates", listRates);
		return "index";
	}
	@RequestMapping("/add")
	public String showAddRateForm(Model model) {
		ForeignExchangeRate foreignExchangeRate = new ForeignExchangeRate();
		model.addAttribute("foreignExchangeRate", foreignExchangeRate);
		return "added_rate";
	}
	//處理th:action="@{/save} 使用到有added_rate.html
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveRate(@ModelAttribute("foreignExchangeRate") ForeignExchangeRate foreignExchangeRate) {
		rateService.saveRate(foreignExchangeRate);
		return "redirect:/";
	}
	
	@RequestMapping("/taifex")
	public String showTaifexRate(Model model) {
		 rateService.saveTaifexRateOneByOne();
			return "redirect:/";
	}
	
	@RequestMapping("/save_all_taifex")
	public String saveAllTaifexRate(Model model) {
		List<ForeignExchangeRate> taifexListRates = rateService.getAllTaifexRates();
		model.addAttribute("taifexListRates", taifexListRates);
			return "taifex";
	}
	//處理th:action="@{/save} 使用到有added_rate.html
//	@RequestMapping(value = "/save",method = RequestMethod.POST)
//	public String saveRate(@ModelAttribute("foreignExchangeRate") ForeignExchangeRate foreignExchangeRate) {
//		rateService.saveRate(foreignExchangeRate);
//		return "redirect:/";
//	}
	
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditRate(@PathVariable(name="id") long id) {
		ModelAndView mav = new ModelAndView("edit_rate");
		ForeignExchangeRate foreignExchangeRate = rateService.getRateById(id);
		mav.addObject("foreignExchangeRate", foreignExchangeRate);
		return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteEditRate(@PathVariable(name="id") long id) {
		rateService.deleteRate(id);
		return "redirect:/";
	}
	
	
}
