package com.uoc.ggymbackend.services;

import com.uoc.ggymbackend.domain.PagosAbonado;
import com.uoc.ggymbackend.domain.vo.AbonadoVO;
import com.uoc.ggymbackend.domain.vo.CentroDeportivoVO;
import com.uoc.ggymbackend.domain.vo.PagosAbonadoVO;
import com.uoc.ggymbackend.repositories.PagosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.*;

@Service
public class PagosService {

    @Autowired
    private PagosRepository pagosRepository;

    @Autowired
    private CentrosService centrosService;

    @Autowired
    private ModelMapper modelMapper;

    public PagosAbonadoVO crearPagos(PagosAbonadoVO pagosAbonadoVO) {
        // Mapear a entidad
        PagosAbonado pagosAbonado = modelMapper.map(pagosAbonadoVO, PagosAbonado.class);
        // Guardar en la base de datos
        pagosAbonado = pagosRepository.save(pagosAbonado);
        // Mapear a VO y devolver
        return modelMapper.map(pagosAbonado, PagosAbonadoVO.class);
    }

    public List<PagosAbonadoVO> obtenerListadoPagosPendientes(Long idCentroDeportivo) {
        // Listado de pagos a devolver
        List<PagosAbonadoVO> listadoPagosPendientes = new ArrayList<>();
        // Obtener el centro deportivo por ID
        CentroDeportivoVO centroDeportivoVO = centrosService.obtenerCentro(idCentroDeportivo);
        // Leer el listado de abonados del centro
        List<AbonadoVO> abonadosVO = centroDeportivoVO.getAbonados();
        // por cada abonado, leer el listado de pagos
        for (AbonadoVO abonado : abonadosVO) {
            // Obtener el listado de pagos
            PagosAbonado pagos = pagosRepository.findByIdAbonadoAndMesAndAnio(abonado.getIdAbonado(), YearMonth.now().getMonthValue(),
                    Calendar.getInstance().get(Calendar.YEAR));
            // Si el pago no existe
            if (pagos == null) {
                PagosAbonadoVO pago = new PagosAbonadoVO();
                pago.setAbonado(abonado);
                pago.setMes(YearMonth.now().getMonthValue());
                pago.setAnio(Calendar.getInstance().get(Calendar.YEAR));
                listadoPagosPendientes.add(new PagosAbonadoVO());
            }
        }
        // Devolver el listaod
        return listadoPagosPendientes;
    }

    public List<PagosAbonadoVO> obtenerListadoPagosAbonados(Long idCentroDeportivo) {
        // Listado de pagos a devolver
        List<PagosAbonadoVO> listadoPagosPendientes = new ArrayList<>();
        // Obtener el centro deportivo por ID
        CentroDeportivoVO centroDeportivoVO = centrosService.obtenerCentro(idCentroDeportivo);
        // Leer el listado de abonados del centro
        List<AbonadoVO> abonadosVO = centroDeportivoVO.getAbonados();
        // por cada abonado, leer el listado de pagos
        for (AbonadoVO abonado : abonadosVO) {
            // Obtener el listado de pagos
            PagosAbonado pagos = pagosRepository.findByIdAbonadoAndMesAndAnio(abonado.getIdAbonado(), YearMonth.now().getMonthValue(),
                    Calendar.getInstance().get(Calendar.YEAR));
            // Si el pago no existe
            if (pagos != null) {
                listadoPagosPendientes.add(modelMapper.map(pagos, PagosAbonadoVO.class));
            }
        }
        // Devolver el listaod
        return listadoPagosPendientes;
    }

    public PagosAbonadoVO obtenerPago(Long idPago) {
        // Obtener el pago solicitado
        Optional<PagosAbonado> optionalPagosAbonado = pagosRepository.findById(idPago);
        if (!optionalPagosAbonado.isPresent()) {
            throw new NoSuchElementException("No se encuentra el pago solicitado");
        }
        // Mapear a VO y devolverlo
        return modelMapper.map(optionalPagosAbonado.get(), PagosAbonadoVO.class);
    }
}
