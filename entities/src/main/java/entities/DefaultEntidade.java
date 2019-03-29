package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="entidade", schema= "public")
public class DefaultEntidade {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="entidade_id_seq")
    @SequenceGenerator(name="entidade_id_seq", sequenceName=  "public.entidade_id_seq", allocationSize=1)
    private Long id;

}
