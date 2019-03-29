package core.usecases;

public interface IExecuteParameter<TResposta, TParametro>
{
    TResposta execute(TParametro parametro);
}
