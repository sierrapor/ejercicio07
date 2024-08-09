package es.cic.ejercicio07;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(FacturaController.class)
public class FacturaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacturaService facturaService;

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testGetFacturaById_Authorized() throws Exception {
        Long facturaId = 1L;
        Factura factura = new Factura(facturaId, "Concepto de prueba", 100.0);
        when(facturaService.getFacturaById(facturaId)).thenReturn(factura);

        mockMvc.perform(get("/facturas/{id}", facturaId))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetFacturaById_Unauthorized() throws Exception {
        Long facturaId = 1L;

        mockMvc.perform(get("/facturas/{id}", facturaId))
                .andExpect(status().isUnauthorized());
    }
}