package usecases.interactors;

import core.usecases.CoreRequest;
import core.usecases.CoreResponse;
import core.usecases.IExecuteParameter;
import entities.DefaultEntidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usecases.gateways.repositories.DefaultRepository;

@Service
public class DefaultInteractor implements IExecuteParameter<CoreResponse<DefaultEntidade>, CoreRequest<DefaultEntidade>> {

    private final DefaultRepository entidadeRepository;

    @Autowired
    public DefaultInteractor(DefaultRepository entidadeRepository){

        this.entidadeRepository = entidadeRepository;
    }

    @Override
    public CoreResponse<DefaultEntidade> execute(CoreRequest<DefaultEntidade> request) {

			  entidadeRepository.save(request.getDados());

        return new CoreResponse<>(request.getDados());
    }
}
