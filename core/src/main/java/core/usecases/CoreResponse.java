package core.usecases;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoreResponse<TEntity> {

    private Boolean isOk;

    private Exception erro;

    private TEntity dados;


    public CoreResponse()
    {
        isOk = true;
        erro = null;
    }

    public CoreResponse(TEntity dados){

        this.dados = dados;
    }

    public CoreResponse(Exception erro)
    {
        isOk = false;
        erro = erro;
    }

}
