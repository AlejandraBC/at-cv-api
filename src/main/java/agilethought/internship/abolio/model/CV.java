package agilethought.internship.abolio.model;

import java.io.ObjectInputFilter.Config;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Document(collection = "cv")
public class CV {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String job;
	private String city;
	private String country;
	private String email;
	private String phoneNumber;
	private List<Skill> skills;
	private List<Language> languages;
	private List<WorkExperience> workexperience;
	private List<Education> education;
	private List<Challenge> challenges;
	private SocialMedia socialMedia;
	private Config config;

	public CV() {
		this.skills = new ArrayList<>();
		this.languages = new ArrayList<>();
		this.workexperience = new ArrayList<>();
		this.education = new ArrayList<>();
		this.challenges = new ArrayList<>();
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Skill {
		private String name;
		private byte percentage;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Language {
		private String name;
		private byte percentage;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class WorkExperience {
		private String title;
		private String company;
		private LocalDate from;
		private LocalDate to;
		private Boolean current;
		private String description;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Education {
		private String name;
		private String career;
		private LocalDate from;
		private LocalDate to;
		private String degree;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Challenge {
		private String name;
		private LocalDate date;
		private String description;
		private String url;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class SocialMedia {
		private String facebook;
		private String instagram;
		private String snapchat;
		private String pinterest;
		private String twitter;
		private String linkedin;
	}
}