package com.codingdojo.ninjagold;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Collections;
import javax.servlet.http.HttpSession;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class NinjaController {
	@RequestMapping("/gold")
		public String index(HttpSession session, Model model) {
	    	// If the gold is not already in session
			if (session.getAttribute("gold") == null) {
			// Use setAttribute to initialize the gold in session
				session.setAttribute("gold", 0);
				Integer currentGold = (Integer) session.getAttribute("gold");
				model.addAttribute("gold", currentGold);
			}
			else {
				Integer currentGold = (Integer) session.getAttribute("gold");
				model.addAttribute("gold", currentGold);
				ArrayList<String> currlog = (ArrayList<String>) session.getAttribute("log");
				model.addAttribute("log", currlog);
			}
			if (session.getAttribute("log") == null) {
				ArrayList<String> log = new ArrayList<String>();
				session.setAttribute("log", log);
				model.addAttribute("log", log);	
			}
			if ((Integer) session.getAttribute("gold") < -100) {
				return "redirect:/debt";
			}
			else {	
				ArrayList<String> currlog = (ArrayList<String>) session.getAttribute("log");
				ArrayList<String> revArrayList = new ArrayList<String>();
			        for (int i = currlog.size() - 1; i >= 0; i--) {
			 
			            // Append the elements in reverse order
			            revArrayList.add(currlog.get(i));
			        }
				model.addAttribute("arrLen", revArrayList);	
				return "index.jsp";
			}
		}
		
	@RequestMapping("/process")
		public String process(HttpSession session,
			@RequestParam(value="gold") String gold) {
		
			Date date = new Date();
			java.text.DateFormat df = new java.text.SimpleDateFormat("MMMM dd  YYYY k:mm  a");
			String formatedDate = df.format(new java.util.Date());
			ArrayList<String> currlog = (ArrayList<String>) session.getAttribute("log");
			
			if (gold.equals("farm")) {
				Random rand = new Random();
				int num =  rand.nextInt(20 - 10) + 10;
				Integer currentGold = (Integer) session.getAttribute("gold");
				currentGold+= num;
				session.setAttribute("gold", currentGold);
				currlog.add("<p style = 'color: green;'>You entered a farm and earned " + num + " gold. ( " + formatedDate + " )</p>");
				session.setAttribute("log", currlog);
			}
			else if (gold.equals("cave")) {
				Random rand = new Random();
				int num =  rand.nextInt(10 - 5) + 5;
				Integer currentGold = (Integer) session.getAttribute("gold");
				currentGold+= num;
				session.setAttribute("gold", currentGold);
				currlog.add("<p style = 'color: green;'>You entered a cave and earned " + num + " gold. ( " + formatedDate + " )</p>");
				session.setAttribute("log", currlog);
			}
			else if (gold.equals("house")) {
				Random rand = new Random();
				int num =  rand.nextInt(5 - 2) + 5;
				Integer currentGold = (Integer) session.getAttribute("gold");
				currentGold+= num;
				session.setAttribute("gold", currentGold);
				currlog.add("<p style = 'color: green;'>You entered a house and earned " + num + " gold. ( " + formatedDate + " )</p>");
				session.setAttribute("log", currlog);
			}
			else if (gold.equals("quest")) {
				Random rand = new Random();
				int num =  rand.nextInt(50 + 50) - 50;
				Integer currentGold = (Integer) session.getAttribute("gold");
				currentGold+= num;
				session.setAttribute("gold", currentGold);
				if (num < 0) {
					currlog.add("<p style = 'color: red;'>You failed a Quest and lost " + num + " gold. Ouch. ( " + formatedDate + " ) </p>");
					session.setAttribute("log", currlog);
				}
				else if (num >= 0) {
					currlog.add("<p style = 'color: green;'>You completed a Quest and earned " + num + " gold. ( " + formatedDate + " ) </p>");
					session.setAttribute("log", currlog);
				}
			}
			else if (gold.equals("spa")) {
				Random rand = new Random();
				int num =  rand.nextInt(20 - 5) + 5;
				Integer currentGold = (Integer) session.getAttribute("gold");
				currentGold-= num;
				session.setAttribute("gold", currentGold);
				currlog.add("<p style = 'color: red;'>You entered a Spa and Lost " + num + " gold. ( " + formatedDate + " )</p>");
				session.setAttribute("log", currlog);
			}
			return "redirect:/gold";
		}
	
			@RequestMapping("/reset")
			public String reset(HttpSession session, Model model) {
				session.setAttribute("gold", 0);
				session.setAttribute("log", null);
				return "redirect:/gold";
		}
			
			@RequestMapping("/debt")
			public String debtPrison() {
				return "debt.jsp";
		}
	}
	


