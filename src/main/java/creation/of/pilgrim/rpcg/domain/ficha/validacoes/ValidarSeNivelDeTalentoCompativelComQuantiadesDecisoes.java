package creation.of.pilgrim.rpcg.domain.ficha.validacoes;

import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.TalentosFicha;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;
import java.util.List;

@Component
public class ValidarSeNivelDeTalentoCompativelComQuantiadesDecisoes implements ValidadorDeDecisoesFicha {
    @Override
    public void validar(List<TalentosFicha> talentosFicha) {

        talentosFicha.forEach(t->{
            if(t.getDecisoesTalentosFichas().size() > t.getPontos())
                throw new InvalidParameterException(String.format("Talento %s não pode tomar tantas decisoes", t.getTalento().getNome()));
        });

    }
}
