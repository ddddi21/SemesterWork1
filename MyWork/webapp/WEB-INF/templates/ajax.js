 $(document).ready(function () {
        let $result = $("search_box-result")
        let rootEl = document.getElementById("search_box-result");
        $('#search').on('keyup', function () {
            rootEl.innerHTML = ""
            var search = $(this).val();
            if ((search !== '') && (search.length > 1)) {
                $.ajax({
                    type: "POST",
                    url: "/ajax_search",
                    data: {'search': search},
                    success: function (msg) {
                        if (msg !== " ") {
                            msg = msg.replace(/\n/ig, '');
                            $result.fadeIn();
                            let msgList = msg.split('!');
                            msgList.forEach(function (item, i, arr) {
                                let itemMas = item.split('#')
                                if (itemMas.length > 1) {
                                    let el = document.createElement("div");
                                    el.innerHTML =
                                        "<div class=\"search_result\"><table><tr><td class=\"search_result-name\"><a href=\"/user?user_id="+ itemMas[4] + "\">" + itemMas[0] + itemMas[1] + '<p>' + itemMas[3]+'</p>'+ "</a></td><td class=\"search_result-btn\"><a href=\"#\">Перейти</a></td> </tr> </table> </div>"
                                    rootEl.appendChild(el);
                                }
                            });
                        } else {
                            rootEl.innerHTML = ""
                            $result.fadeOut(100);
                        }
                    }
                })
            } else {
                $result.html('');
                rootEl.innerHTML = ""
                $result.fadeOut(100);
            }
        });
    })
