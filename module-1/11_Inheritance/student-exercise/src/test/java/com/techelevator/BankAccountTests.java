package com.techelevator;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.lang.reflect.*;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BankAccountTests {

    private static Class account;

    @BeforeClass
    public static void classShouldExist() {
        try {
            account = Class.forName("com.techelevator.BankAccount");
        } catch (Exception e) {
            fail("com.techelevator.BankAccount class does not exist");
        }
    }

    @Test
    public void shouldContainFieldAccountHolderName() {
        Field f = SafeReflection.getDeclaredField(account, "accountHolderName");
        assertNotNull("Field accountHolderName does not exist", f);
        assertEquals("Field accountHolderName should be of Type String", "java.lang.String", f.getType().getName());
        assertTrue("Field accountHolderName should be private",Modifier.isPrivate(f.getModifiers()));
    }

    @Test
    public void shouldContainFieldAccountNumber() {
        Field f = SafeReflection.getDeclaredField(account, "accountNumber");
        assertNotNull("Field accountNumber does not exist", f);
        assertEquals("Field accountNumber should be of Type String", "java.lang.String", f.getType().getName());
    }

    @Test
    public void shouldContainFieldBalance() {
        Field f = SafeReflection.getDeclaredField(account, "balance");
        assertNotNull("Field balance does not exist",f);
        
        if(f.getType().getName().equals(BigDecimal.class.getTypeName())) {
            assertEquals("Field balance should be of Type int or BigDecimal", BigDecimal.class.getTypeName(), f.getType().getName());
        } else {
            assertEquals("Field balance should be of Type int or BigDecimal", "int", f.getType().getName());
        }
    }

    @Test
    public void bankAccountHasTwoArgsConstructor() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = SafeReflection.getConstructor(account,String.class, String.class);
        assertNotNull("com.techelevator.BankAccount should contain a 2 argument constructor that sets account holder name and number.",constructor);
    }

    @Test
    public void bankAccountHasThreeArgsConstructor() {
        Constructor constructor = SafeReflection.getConstructor(account,String.class, String.class, int.class);
        if(constructor == null) {
        	constructor = SafeReflection.getConstructor(account,String.class, String.class, BigDecimal.class);
        }
        assertNotNull("com.techelevator.BankAccount should contain a 3 argument constructor that sets account holder name, number and balance.",constructor);
    }

    @Test
    public void twoArgumentConstructorShouldSetNameAndNumber() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(account,String.class, String.class);
        assertNotNull("com.techelevator.BankAccount should contain a 2 argument constructor that sets account holder name and number.",constructor);

        Object bankAccount = constructor.newInstance("John Smith", "CHK:1234");

        Method getAccountNameHolder = bankAccount.getClass().getMethod("getAccountHolderName");
        assertEquals("John Smith", getAccountNameHolder.invoke(bankAccount));

        Method getAccountNumber = bankAccount.getClass().getMethod("getAccountNumber");
        assertEquals("CHK:1234", getAccountNumber.invoke(bankAccount));

        Method getBalance = bankAccount.getClass().getMethod("getBalance");
        
        if(getBalance.getReturnType().getName().equals(BigDecimal.class.getTypeName())) {
        	assertEquals(BigDecimal.ZERO, getBalance.invoke(bankAccount));
        } else {
        	assertEquals(0, getBalance.invoke(bankAccount));
        }
    }

    @Test
    public void newCustomerHasZeroBalance() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(account,String.class, String.class);
        Object bankAccount = constructor.newInstance("","");
        Method getBalance = bankAccount.getClass().getMethod("getBalance");
        
        if(getBalance.getReturnType().getName().equals(BigDecimal.class.getTypeName())) {
        	assertEquals(BigDecimal.ZERO, getBalance.invoke(bankAccount));
        } else {
        	assertEquals(0, getBalance.invoke(bankAccount));
        }
    }

    @Test
    public void threeArgumentConstructorShouldSetNameNumberAndBalance() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(account,String.class, String.class, int.class);

        if(constructor == null) {
        	constructor = SafeReflection.getConstructor(account,String.class, String.class, BigDecimal.class);
        
            assertNotNull("com.techelevator.BankAccount should contain a 3 argument constructor that sets account holder name, number and balance.",constructor);

        	Object bankAccount = constructor.newInstance("John Smith","CHK:1234", BigDecimal.ONE);
            Method getAccountNameHolder = bankAccount.getClass().getMethod("getAccountHolderName");
            assertEquals("John Smith", getAccountNameHolder.invoke(bankAccount));

            Method getAccountNumber = bankAccount.getClass().getMethod("getAccountNumber");
            assertEquals("CHK:1234", getAccountNumber.invoke(bankAccount));

            Method getBalance = bankAccount.getClass().getMethod("getBalance");
            assertEquals(BigDecimal.ONE, getBalance.invoke(bankAccount));
        } else {
            assertNotNull("com.techelevator.BankAccount should contain a 3 argument constructor that sets account holder name, number and balance.",constructor);
           
            Object bankAccount = constructor.newInstance("John Smith","CHK:1234", 1);
            Method getAccountNameHolder = bankAccount.getClass().getMethod("getAccountHolderName");
            assertEquals("John Smith", getAccountNameHolder.invoke(bankAccount));

            Method getAccountNumber = bankAccount.getClass().getMethod("getAccountNumber");
            assertEquals("CHK:1234", getAccountNumber.invoke(bankAccount));

            Method getBalance = bankAccount.getClass().getMethod("getBalance");
            assertEquals(1, getBalance.invoke(bankAccount));
        }        
    }

    @Test
    public void accountHolderNameShouldOnlyHaveAGetter() {
        assertTrue("Account Holder Name field should have a getter",SafeReflection.hasGetter(account, "AccountHolderName"));
        assertFalse("Account Holder Name field should not have a setter",SafeReflection.hasSetter(account, "AccountHolderName"));
    }

    @Test
    public void accountNumberShouldOnlyHaveAGetter() throws NoSuchMethodException {
        assertTrue("Account Number field should have a getter",SafeReflection.hasGetter(account, "AccountNumber"));
        assertFalse("Account Number field should not have a setter",SafeReflection.hasSetter(account, "AccountNumber"));
    }

    @Test
    public void balanceShouldOnlyHaveAGetter() throws NoSuchMethodException {
        assertTrue("Balance field should have a getter",SafeReflection.hasGetter(account, "Balance"));
        assertFalse("Balance field should not have a setter method",SafeReflection.hasSetter(account, "Balance"));
    }

    @Test
    public void depositIncreasesBalance() throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(account,String.class, String.class);
        Object bankAccount = constructor.newInstance("","");

        
        Method deposit;
        
        try {
        	deposit = bankAccount.getClass().getMethod("deposit", int.class);
        	assertEquals(1, deposit.invoke(bankAccount, 1));
        	
        	Method getBalance = bankAccount.getClass().getMethod("getBalance");
            assertEquals(1, getBalance.invoke(bankAccount));
            
            return;
            
        } catch (NoSuchMethodException e) {
        	
        }
        
        deposit = bankAccount.getClass().getMethod("deposit", BigDecimal.class);
    	assertEquals(BigDecimal.ONE, deposit.invoke(bankAccount, BigDecimal.ONE));
    	
    	Method getBalance = bankAccount.getClass().getMethod("getBalance");
        assertEquals(BigDecimal.ONE, getBalance.invoke(bankAccount));
    }

    @Test
    public void withdrawDecreasesBalance() throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Constructor constructor = SafeReflection.getConstructor(account,String.class, String.class);
        Object bankAccount = constructor.newInstance("","");

        Method withdraw;
        
        try {
        	withdraw = bankAccount.getClass().getMethod("withdraw", int.class);
            assertEquals(-1, withdraw.invoke(bankAccount, 1));

            Method getBalance = bankAccount.getClass().getMethod("getBalance");
            assertEquals(-1, getBalance.invoke(bankAccount));
            
            return;
            
        } catch (NoSuchMethodException e) {
        	
        }
        
        withdraw = bankAccount.getClass().getMethod("withdraw", BigDecimal.class);
    	assertEquals(BigDecimal.valueOf(-1), withdraw.invoke(bankAccount, BigDecimal.ONE));
    	
    	Method getBalance = bankAccount.getClass().getMethod("getBalance");
        assertEquals(BigDecimal.valueOf(-1), getBalance.invoke(bankAccount)); 
        
    }

}
