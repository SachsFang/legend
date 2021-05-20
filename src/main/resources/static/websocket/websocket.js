var stompClient = null;
function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
    document.getElementById('response').innerHTML = '';
}
// 开启socket连接
function connect() {
    var socket = new SockJS('/socket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connect');
        setConnected(true);
    });
    sub();
}
// 断开socket连接
function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}
// 向‘/app/change-notice’服务端发送消息
function sendName() {
    var value = document.getElementById('content').value;
    stompClient.send("/app/changeNotice", {}, value);
    document.getElementById('content').value = '';
}
//订阅
function sub() {
    stompClient.connect({}, () => {
        stompClient.subscribe('/topic/notice', response => {
            if (response) {
                document.getElementById('response').textContent += '\n' + response.body;;
                console.log(response.body);
            }
        }, error => {
            console.log('error:' + error);
        });
    });
}
connect();
