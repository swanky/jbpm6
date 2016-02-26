package io.github.swanky.example1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Applicant {
	private String name;
	private int age;
	private boolean valid;
}