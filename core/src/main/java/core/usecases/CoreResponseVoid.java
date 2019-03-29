package core.usecases;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoreResponseVoid {

    private Boolean isOk;

    private Exception erro;

    public CoreResponseVoid()
    {
        isOk = true;
        erro = null;
    }

    public CoreResponseVoid(Exception erro)
    {
        isOk = false;
        erro = erro;
    }

}
