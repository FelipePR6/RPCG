package creation.of.pilgrim.rpcg.domain.ficha.validacoes;

import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.TalentosFicha;
import creation.of.pilgrim.rpcg.domain.talento.NivelTalento;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ValidarSeDecisoesPodemSerFeitas implements ValidadorDeDecisoesFicha{
    @Override
    public void validar(List<TalentosFicha> talentosFicha) {

        talentosFicha.forEach(t -> {
            if(t.getDecisoesTalentosFichas() != null) {

                List<NivelTalento> nivelTalentos = new ArrayList<>(t.getTalento().getNiveisTalento());
                t.getDecisoesTalentosFichas().forEach(decisoes -> {

                    var decisaoNoNivelTanlento = nivelTalentos.stream().filter(n -> n.getTipoDeDecisao()
                            .equals(decisoes.getOpcoesDecisoes().getTipoDecisao().getTipoDeDecisao())).toList();

                    if(decisaoNoNivelTanlento.size() == 0){
                        throw new InvalidParameterException(String.format("Alguma decisao não pode ser tomada no talento %s", t.getTalento().getNome()));
                    } else{
                        nivelTalentos.remove(decisaoNoNivelTanlento.get(0));
                    }
                });

            }
        });

    }

}
