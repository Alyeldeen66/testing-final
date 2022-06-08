import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import sample.Money;

public class MoneyTest {
    @Test
    void test1(){ assertEquals(1500,Money.getBalance()); }
    @Test
    void test2(){ assertEquals(1500,Money.AddToBalance(55000));}
    @Test
    void test3(){
        assertEquals(1500,Money.AddToBalance(20));
    }
    @Test
    void test4(){
        assertTrue(Money.canPurchase(1500));
    }
    @Test
    void test5(){ assertFalse(Money.canPurchase(1600));}
    @Test
    void test6(){
        assertEquals(1500,Money.getBalance());
        assertTrue(Money.canPurchase(1500));
        Money.purchase(200);
        assertFalse(Money.canPurchase(1500));
        Money.AddToBalance(200);
    }
    @Test
    void test7(){
        assertEquals(1500,Money.getBalance());
        assertFalse(Money.canPurchase(1700));
        Money.AddToBalance(200);
        assertTrue(Money.canPurchase(1700));
        Money.purchase(200);
    }
    @Test
    void test8(){
        assertEquals(1500,Money.getBalance());
        assertTrue(Money.canTransfer(700));
        assertFalse(Money.canTransfer(20));
        assertFalse(Money.canTransfer(60000));
    }
    @Test
    void test9(){
        assertEquals(1500,Money.getBalance());
        assertFalse(Money.canTransfer(2000));
        Money.AddToBalance(500);
        assertTrue(Money.canTransfer(2000));
        Money.purchase(500);
    }
    @Test
    void test10(){
        assertEquals(1500,Money.getBalance());
        assertTrue(Money.canTransfer(1000));
        Money.purchase(1000);
        assertFalse(Money.canTransfer(1000));
        Money.AddToBalance(1000);
    }



}
