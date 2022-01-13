$('#pokemon').focus();
let idpokemon;
let idpokemonprecedent;
let idpokemonsuivant;

function ajouter(id,param1,param2,param3,param4,param5 ) {

    $.getJSON( "https://pokeapi.co/api/v2/pokemon/"+id, function(donnees) {
        console.log( "success" );
        param1.text('nom : '+donnees.name);
        param2.attr('src', donnees.sprites.front_default);
        param3.text('ID : '+donnees.id)
        idpokemon = donnees.id;
  //      idpokemonprecedent = donnees.id-1
   //     idpokemonsuivant = donnees.id+1
        param4.empty();
        for (const slot of donnees.types) {
            let element = $('<li>' +'type : ' +slot.type.name + '</li>'); // Je créé un nouvel élement
            param4.append(element); // Et je l'accroche dans le DOM
        }
        param5.text('Poids : ' + donnees.weight);

    }).done(function() {
        console.log( "second success" );
        console.log(idpokemon);
     //   console.log(idpokemonsuivant);
   //     console.log(idpokemonprecedent);
    })
        .fail(function() {
            console.log( "error" );
            alert("le pokemon n'existe pas")
        })
        .always(function() {
            console.log( "complete" );
        });
}

$("#pokemon").keypress(function(event) {
    if (event.keyCode === 13) {
        let pokemon = $('#pokemon').val();
        ajouter(pokemon,$('#nom'),$('#image'),$('#idpok'),$('#types'),$('#poids') )
        setTimeout(() => { ajouter(idpokemon+1,$('#nomsuivant'),$('#imagesuivant'),$('#idpoksuivant'),$('#typessuivant'),$('#poidssuivant') ); }, 200);
        setTimeout(() => { ajouter(idpokemon-1,$('#nomprecedent'),$('#imageprecedent'),$('#idpokprecedent'),$('#typesprecedent'),$('#poidsprecedent') ); }, 200);

    }
});
function precedent(){
    console.log("salut");

    setTimeout(() => { ajouter(idpokemon,$('#nom'),$('#image'),$('#idpok'),$('#types'),$('#poids') ); }, 1000);
    setTimeout(() => { ajouter(idpokemon+1,$('#nomsuivant'),$('#imagesuivant'),$('#idpoksuivant'),$('#typessuivant'),$('#poidssuivant') ); }, 1000);
    setTimeout(() => { ajouter(idpokemon-1,$('#nomprecedent'),$('#imageprecedent'),$('#idpokprecedent'),$('#typesprecedent'),$('#poidsprecedent') ); }, 1000);

}
function suivant(){
    console.log("salut");

    setTimeout(() => { ajouter(idpokemon+2,$('#nom'),$('#image'),$('#idpok'),$('#types'),$('#poids') ); }, 1000);
    setTimeout(() => { ajouter(idpokemon+1,$('#nomsuivant'),$('#imagesuivant'),$('#idpoksuivant'),$('#typessuivant'),$('#poidssuivant') ); }, 1000);
    setTimeout(() => { ajouter(idpokemon-1,$('#nomprecedent'),$('#imageprecedent'),$('#idpokprecedent'),$('#typesprecedent'),$('#poidsprecedent') ); }, 1000);

}
