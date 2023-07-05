package com.eviro.assessment.grad001.MorganneMatoka.Assessment;

import com.eviro.assessment.grad001.MorganneMatoka.Assessment.controller.AccountProfileReader;
import com.eviro.assessment.grad001.MorganneMatoka.Assessment.entity.AccountProfile;
import com.eviro.assessment.grad001.MorganneMatoka.Assessment.repository.AccountProfileRepository;
import com.eviro.assessment.grad001.MorganneMatoka.Assessment.service.AccountService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URI;
import java.util.List;

@SpringBootApplication
@RequestMapping
public class AssessmentApplication {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountProfileRepository accountProfileRepository;

	public static void main(String[] args) {
		SpringApplication.run(AssessmentApplication.class, args);
	}

	@RestController
	public class AccountProfileController {

		@GetMapping("/triggerAddAccountProfiles")
		public String triggerAddAccountProfiles() {
			// Path to the CSV file
			File csvFile = new File("C:\\Users\\Morganne\\Desktop\\fileAssest.csv");

			// Create an instance of AccountProfileReader
			AccountProfileReader accountProfileReader = new AccountProfileReader();

			// Parse the CSV file
			accountProfileReader.parseCSV(csvFile);

			// Get the data list from the CSV
			List<String[]> dataList = accountProfileReader.getDataList();

			// Iterate over the data list and create account profiles
			for (int i = 1; i < dataList.size(); i++) {
				String name = dataList.get(i)[0];
				String surname = dataList.get(i)[1];
				String base64Image = dataList.get(i)[3];

				// Convert base64 image data to a file
				File imageFile = accountProfileReader.convertedCSVDataToImage(base64Image);

				// Create an HTTP link for the image
				URI imageLink = accountProfileReader.createImageLink(imageFile);

				// Create an AccountProfile object
				AccountProfile accountProfile = new AccountProfile(name, surname, imageLink.toString());

				// Add the account profile using the AccountService
				accountService.addAccount(accountProfile);

			}
			return "file read from and accounts added go back to read from files";
		}
	}
}
