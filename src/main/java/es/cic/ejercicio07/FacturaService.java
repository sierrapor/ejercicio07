package es.cic.ejercicio07;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    @PreAuthorize("hasRole('ROLE_USER')")
    public Factura getFacturaById(Long id) {
        // Como no hay repositorio devuelvo una instancia de Factura.
        Factura factura = new Factura();
        factura.setId(id);
        factura.setConcepto("Móvil nuevo");
        factura.setImporte(199.90);
        return factura;
    }
}