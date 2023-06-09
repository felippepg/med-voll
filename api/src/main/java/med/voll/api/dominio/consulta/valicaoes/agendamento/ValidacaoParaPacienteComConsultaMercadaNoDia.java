package med.voll.api.dominio.consulta.valicaoes.agendamento;

import med.voll.api.config.exception.ValidacaoException;
import med.voll.api.dominio.consulta.ConsultaRepository;
import med.voll.api.dominio.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoParaPacienteComConsultaMercadaNoDia implements ValidacoesAgendarConsultas {

    @Autowired
    ConsultaRepository consultaRepository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        Boolean consulta = consultaRepository.existsByPacienteIdAndData(dados.pacienteId(), dados.data());

        if(consulta) {
            throw new ValidacaoException("O paciente já possui consulta marcada no dia de hoje");
        }
    }
}
