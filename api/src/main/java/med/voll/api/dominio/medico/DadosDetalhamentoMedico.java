package med.voll.api.dominio.medico;

import med.voll.api.dominio.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String CRM, String telefone, Especialidade especialidade, Endereco endereco) {
    public DadosDetalhamentoMedico (Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCRM(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());

    }
}