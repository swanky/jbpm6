package io.github.swanky.example2;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Application {
	private Date dateApplied;
	private boolean valid;
}
