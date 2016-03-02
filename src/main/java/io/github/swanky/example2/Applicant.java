package io.github.swanky.example2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Applicant {
	private String name;
	private int age;
}