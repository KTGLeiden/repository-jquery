
function getMovies() {
    $.get("api/movies", function (movies) {
        $("#movies").empty();
        for (var i = 0; i < movies.length; i++) {
            // Do something
            const movie = movies[i];
            $("#movies").append('<p>' + movie.title + '</p>');
        }
    });
}

function postMovie() {
    var movie = {
        title: $("#titleInput").val(),
        year: Number($("#yearInput").val()),
        rating: Number($("#ratingInput").val())
    };


    var jsonObject = JSON.stringify(movie);

    $.ajax({
        url: "api/movies",
        type: "POST",
        contentType: "application/json",
        data: jsonObject,
        success: function () {
            alert('We succeeded!');
            $("#titleInput").val('');
            $("#yearInput").val('');
            $("#ratingInput").val('');
        },
        error: function () {
            alert('NOOOOOOOOOOOOOOOOOOOOOOOOO');
        }
    });
}


$(document).ready(function () {
    $("#getButton").click(getMovies);
    $("#postButton").click(postMovie);
});