package core.usecases;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoreRequest<TEntity> {

    private TEntity dados;
}
