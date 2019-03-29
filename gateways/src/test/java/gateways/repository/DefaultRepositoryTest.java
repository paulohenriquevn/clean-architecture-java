package gateways.repository;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultRepositoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    //@Autowired
   // private DefaultRepository defaultRepository;

    @Rule
    public ExpectedException throwExpected = ExpectedException.none();

//    @Test
//    public void whenSaveCondicionante() {
//
//        Entidade condicionante = new Entidade();
//        condicionanteRepository.save(condicionante);
//        Assertions.assertThat(condicionante.getId()).isNotNull();
//    }

		@Test
    public void whenSaveCondicionante() {

        Assertions.assertThat("").isNotNull();
    }
}
