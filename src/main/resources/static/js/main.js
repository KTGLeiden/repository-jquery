
function getMovies() {
    $.get("api/movies", function (movies) {
        console.log(movies);
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