package basballgame.ui.input;

import java.util.function.Predicate;

import basballgame.exception.ValidationException;
import basballgame.ui.GameMessages;
import basballgame.ui.output.Output;

public class BaseballNumberInput {
	public static String input() {
		return Input.withGuideAndValidator(GameMessages.NUMBER_INPUT_REQUEST_TEXT, getInputValidate());
	}

	private static Predicate<String> getInputValidate() {
		return (inputString) -> {
			try {
				InputValidator.validateBaseballNumberInput(inputString);
			} catch (ValidationException e) {
				Output.println(e.getMessage());
				return false;
			}
			return true;
		};
	}
}
