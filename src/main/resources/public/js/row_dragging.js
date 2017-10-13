$( function() {
            var startDragCol = 0, endDragCol = 0;
            var cols = ["BACKLOG", "IN_PROGRESS", "DONE"]
            function calcDragCol(x){
                var x1 = $("#column1").offset().left;
                var x2 = $("#column2").offset().left;
                var x3 = $("#column3").offset().left;
                if (x < x2) return 1;
                if (x > x3) return 3;
                return 2;
            }
            $(".draggable").draggable({
                start: function(e){
                    startDragCol = calcDragCol(e.pageX);
                },
                stop: function(e){
                    endDragCol = calcDragCol(e.pageX);
                    if (startDragCol !== endDragCol) {
                        var text = e.target.innerText;
                        var texts = text.split('%');
                        var taskName = texts[1];
                        var url = "/taskUpdateStatus?name=" + taskName + "&column=" + cols[endDragCol - 1];
                        $.post(url, function(response){
                            location.reload(); // To see updated table
                        });
                    }
                },
                revert: true
            });
        });