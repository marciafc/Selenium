package br.com.marcia.selenium.junit;

import org.junit.*;

public class JunitTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass - Método executado uma única vez ANTES de todos os outros métodos");
    }

    @Before
    public void before() {
        System.out.println("@Before - Método executado ANTES de todos métodos com anotação @Test");
    }

    @Test
    public void test1() {
        System.out.println("@Test - Teste 1");
    }

    @Test
    public void test2() {
        System.out.println("@Test - Teste 2");
    }

    @After
    public void after() {
        System.out.println("@After - Método executado DEPOIS de todos métodos com anotação @Test");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass - Método executado uma única vez DEPOIS de todos os outros métodos");
    }

}
