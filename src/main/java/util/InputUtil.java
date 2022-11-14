package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

	public static long inputPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		String inputValue = Console.readLine();

		if (!ValidateUtil.isNumber(inputValue)) {
			ExceptionUtil.makeException("구입금액은 숫자로 입력해야 합니다.");
		}
		if (!ValidateUtil.isMultipleOf1000(inputValue)) {
			ExceptionUtil.makeException("구입금액은 1000단위로 입력해야 합니다.");
		}

		return Integer.parseInt(inputValue);
	}

	public static List<Integer> inputWinnigNumber() {
		System.out.println("당첨 번호를 입력해 주세요.");
		String inputValue = Console.readLine();

		List<String> inputSplit = Arrays.asList(inputValue.split(","));
		
		if (!ValidateUtil.checkListSize(inputSplit, 6)) {
			ExceptionUtil.makeException("당첨번호는 6개로 이루어져야 합니다.");
		}
		
		for(String number: inputSplit) {
			if (!ValidateUtil.isNumber(number)) {
				ExceptionUtil.makeException("당첨번호는 숫자로 입력해야 합니다.");
			}
		}
		
		List<Integer> winnigNumber = stringListToIntegerList(inputSplit);
		return winnigNumber;
	}

	private static List<Integer> stringListToIntegerList(List<String> strTarget) {
		
		List<Integer> result = new ArrayList<Integer>();
		for(String target :  strTarget) {
			result.add(Integer.parseInt(target));
		}
		return result;
	}

}
