import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sample.Money;


public class TransferMoneyTest {
    @Test
    void test1(){ assertEquals(1500,Money.getBalance()); }
    @Test
    void test2(){
        assertTrue(Money.canTransfer(1000));
    }
    @Test
    void test3(){
        assertFalse(Money.canTransfer(2000));}
    @Test
    void test4(){
        Money.AddToBalance(500);
        assertTrue(Money.canTransfer(2000));
        Money.purchase(500);
    }
    @Test
    void test5(){
        assertEquals(1500,Money.getBalance());
        assertFalse(Money.canTransfer(20));
    }
    @Test
    void test6(){
        assertEquals(1500,Money.getBalance());
        assertFalse(Money.canTransfer(60000));
    }
    @Test
    void test7(){
        assertEquals(1500,Money.getBalance());
        Money.AddToBalance(60000);
        assertFalse(Money.canTransfer(60000));
    }
    @Test
    void test8(){
        assertEquals(1500,Money.getBalance());
        assertFalse(Money.canTransfer(5000));
        Money.AddToBalance(2000);
        assertFalse(Money.canTransfer(5000));
        Money.AddToBalance(2000);
        assertTrue(Money.canTransfer(5000));
        Money.purchase(4000);
    }
    @Test
    void test9(){
        assertEquals(1500,Money.getBalance());
        assertTrue(Money.canTransfer(500));
        Money.purchase(500);
        assertTrue(Money.canTransfer(1000));
        Money.purchase(1000);
        assertFalse(Money.canTransfer(1000));
        Money.AddToBalance(1500);
    }
    @Test
    void test10(){
        assertEquals(1500,Money.getBalance());
        assertFalse(Money.canTransfer(40));
        Money.AddToBalance(40);
        assertFalse(Money.canTransfer(40));

    }
}
