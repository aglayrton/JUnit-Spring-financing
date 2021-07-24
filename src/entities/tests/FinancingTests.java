package entities.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;

public class FinancingTests {

	/*
	 * Construtor 
	 * Deve criar o objeto com os dados corretos quando os dados forem válidos 
	 * Deve lançar IllegalArgumentException quando os dados não forem válidos
	 */

	/*
	 * VÁLIDO porque a entrada seria 20000 e a prestação seria 1000. Neste caso, a
	 * prestação é menor ou igual a metade da renda do cliente, satisfazendo a
	 * regra.
	 */
	@Test
	public void constructorShouldCreateObjectWhenDataValid() {

		Financing fn = new Financing(100000.0, 2000.0, 80);

		Assertions.assertEquals(100000.0, fn.getTotalAmount());
		Assertions.assertEquals(2000.0, fn.getIncome());
		Assertions.assertEquals(80, fn.getMonths());
		;
	}

	/*
	 * NVÁLIDO porque com esses dados a entrada seria 20000 e a prestação seria
	 * 4000. Porém a prestação não pode passar de 1000, que é a metade da renda do
	 * cliente.
	 */
	@Test
	public void constructorShouldThrowIllegalArgumentExceptionWhenInvalidData() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fn = new Financing(100000.0, 2000.0, 40);
		});
	}

	/*
	 * setTotalAmount 
	 * Deve atualizar o valor quando os dados forem válidos 
	 * Deve lançar IllegalArgumentException quando os dados não forem válidos
	 */
	@Test
	public void setTotalAmountShouldUpdateWheDataValid() {
		// arrange
		Financing fn = new Financing(100000.0, 2000.0, 80);

		// action
		fn.setTotalAmount(90000.00);

		// assert
		Assertions.assertEquals(90000.0, fn.getTotalAmount());
	}

	@Test
	public void setTotalAmountShouldIllegalArgumentExceptionWheDataValid() {
		// arrange
		Financing fn = new Financing(100000.0, 2000.0, 80);
		// assert e action
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			fn.setTotalAmount(200000.00);
		});
	}
}
