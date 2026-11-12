package ies.juanbosco.POJOs;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@RequiredArgsConstructor
public class movimiento {
    private int id;
    private int idPokemon;
    private String tipo;
}
