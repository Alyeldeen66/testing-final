import org.junit.jupiter.api.Test;
import sample.Money;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BillsTest {
        @Test
        void test1(){ assertTrue(Money.canPurchase(800));}
        @Test
        void test2(){
            assertFalse(Money.canPurchase(1600));
        }
        @Test
        void test3(){
            assertTrue(Money.canPurchase(1500));
        }
        @Test
        void test4(){assertTrue(Money.canPurchase(1499));}
        @Test
        void test5(){ assertFalse(Money.canPurchase(1501)); }
        @Test
        void test6(){
            assertEquals(1500,Money.getBalance());
            assertFalse(Money.canPurchase(1501));
        }
        @Test
        void test7(){
            assertEquals(1500,Money.getBalance());
            assertFalse(Money.canPurchase(1501));
            assertEquals(2000,Money.AddToBalance(500));
            assertTrue(Money.canPurchase(1501));
            Money.purchase(500);
        }
        @Test
        void test8(){
            assertEquals(1500,Money.getBalance());
            assertTrue(Money.canPurchase(500));
            Money.purchase(1200);
            assertFalse(Money.canPurchase(500));
            Money.AddToBalance(1200);
        }
        @Test
        void test9(){
            assertEquals(1500,Money.getBalance());
            assertFalse(Money.canPurchase(2500));
            Money.AddToBalance(1000);
            assertEquals(2500,Money.getBalance());
            assertTrue(Money.canPurchase(2500));
            Money.purchase(1000);
        }
        @Test
        void test10(){
            assertEquals(1500,Money.getBalance());
            Money.AddToBalance(1000);
            assertTrue(Money.canPurchase(2000));
            Money.purchase(2000);
            assertFalse(Money.canPurchase(1000));
            Money.AddToBalance(1000);
        }

}
