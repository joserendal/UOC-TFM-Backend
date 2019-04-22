package com.uoc.ggymbackend.services;

import com.uoc.ggymbackend.domain.Abonado;
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
    private AbonadosService abonadosService;

    @Autowired
    private ModelMapper modelMapper;

    public PagosAbonadoVO crearPagos(PagosAbonadoVO pagosAbonadoVO) {
        // Mapear a entidad
        PagosAbonado pagosAbonado = modelMapper.map(pagosAbonadoVO, PagosAbonado.class);
        // OBtener los detalles del abonado
        /*AbonadoVO abonadoVO = abonadosService.obtenerAbonado(pagosAbonadoVO.getIdAbonado());
        Abonado abonado = modelMapper.map(abonadoVO, Abonado.class);
        pagosAbonado.setIdAbonado(abonado);*/
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
        for (AbonadoVO abonadoVO : abonadosVO) {
            // Mapear a abonado
            Abonado abonado = modelMapper.map(abonadoVO, Abonado.class);
            // Obtener el listado de pagos
            PagosAbonado pagos = pagosRepository.findByIdAbonadoAndMesAndAnio(abonado, YearMonth.now().getMonthValue(),
                    Calendar.getInstance().get(Calendar.YEAR));
            // Si el pago no existe
            if (pagos == null) {
                PagosAbonadoVO pago = new PagosAbonadoVO();
                pago.setIdAbonado(abonadoVO);
                pago.setMes(YearMonth.now().getMonthValue());
                pago.setAnio(Calendar.getInstance().get(Calendar.YEAR));
                listadoPagosPendientes.add(pago);
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
        for (AbonadoVO abonadoVO : abonadosVO) {
            // Mapear a abonado
            Abonado abonado = modelMapper.map(abonadoVO, Abonado.class);
            // Obtener el listado de pagos
            PagosAbonado pagos = pagosRepository.findByIdAbonadoAndMesAndAnio(abonado, YearMonth.now().getMonthValue(),
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
