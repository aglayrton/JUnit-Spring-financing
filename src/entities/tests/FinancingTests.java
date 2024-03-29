package entities.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;

public class FinancingTests {

	/*
	 * Construtor Deve criar o objeto com os dados corretos quando os dados forem
	 * v�lidos Deve lan�ar IllegalArgumentException quando os dados n�o forem
	 * v�lidos
	 */

	/*
	 * V�LIDO porque a entrada seria 20000 e a presta��o seria 1000. Neste caso, a
	 * presta��o � menor ou igual a metade da renda do cliente, satisfazendo a
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
	 * NV�LIDO porque com esses dados a entrada seria 20000 e a presta��o seria
	 * 4000. Por�m a presta��o n�o pode passar de 1000, que � a metade da renda do
	 * cliente.
	 */
	@Test
	public void constructorShouldThrowIllegalArgumentExceptionWhenInvalidData() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fn = new Financing(100000.0, 2000.0, 40);
		});
	}

	/*
	 * setTotalAmount Deve atualizar o valor quando os dados forem v�lidos Deve
	 * lan�ar IllegalArgumentException quando os dados n�o forem v�lidos
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

	/*
	 * setIncome Deve atualizar o valor quando os dados forem v�lidos Deve lan�ar
	 * IllegalArgumentException quando os dados n�o forem v�lidos
	 */

	@Test
	public void setIncomeShouldUpdateWhenDataValids() {

		Financing fn = new Financing(100000.0, 2000.0, 80);

		fn.setIncome(9000.0);

		Assertions.assertEquals(9000, fn.getIncome());

	}

	@Test
	public void setIncomeShouldIllegalArgumentException() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fn = new Financing(100000.0, 2000.0, 80);

			fn.setIncome(1000.0);
		});

	}

	/*
	 * setMonths Deve atualizar o valor quando os dados forem v�lidos 
	 * Deve lan�ar IllegalArgumentException quando os dados n�o forem v�lidos
	 */
	@Test
	public void setMonthsShouldUpdateWhenDataValids() {

		Financing fn = new Financing(100000.0, 2000.0, 80);

		fn.setMonths(90);

		Assertions.assertEquals(90, fn.getMonths());

	}

	@Test
	public void setMonthsShouldIllegalArgumentException() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fn = new Financing(100000.0, 2000.0, 80);

			fn.setMonths(10);
		});

	}
	
	/*Deve calcular corretamente o valor da entrada*/
	@Test
	public void entryShouldCalculateEntryCorrectly() {
		Financing fn = new Financing(100000.0, 2000.0, 80);
		Assertions.assertEquals(20000, fn.entry());
	}
	/*Deve calcular corretamente o valor da entrada*/
	@Test
	public void quotaShouldCalculateEntryCorrectly() {
		Financing fn = new Financing(100000.0, 2000.0, 80);
		Assertions.assertEquals(1000, fn.quota());
	}
	
	

}
