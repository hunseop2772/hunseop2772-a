while (true) {
    let cnt = 0;
    var q1 = prompt('가위,바위,보 중에 하나를 입력하세요');
    let num = Math.floor(Math.random() * 3 + 1);
    var com = '';
    switch (num) {
        case 1:
            com = '가위';
            break;
        case 2:
            com = '바위';
            break;
        case 3:
            com = '보';
            break;
    }
    if(q1 == '가위'){
        switch (com){
            case '가위':
                alert('나=가위/컴퓨터=가위 비겼습니다');
                break;
            case '바위':
                alert('나=가위/컴퓨터=바위 졌습니다');
                break;
            case '보':
                alert('나=가위/컴퓨터=보 이겼습니다');
                cnt++;
                break;
        }
    }
    if(q1 == '바위'){
        switch (com){
            case '가위':
                alert('나=바위/컴퓨터=가위 이겼습니다');
                cnt++;
                break;
            case '바위':
                alert('나=바위/컴퓨터=바위 비겼습니다');
                break;
            case '보':
                alert('나=바위/컴퓨터=보 졌습니다');
                break;
        }
    }
    if(q1 == '보'){
        switch (com){
            case '가위':
                alert('나=보/컴퓨터=가위 졌습니다');
                break;
            case '바위':
                alert('나=보/컴퓨터=바위 이겼습니다');
                cnt++;
                break;
            case '보':
                alert('나=보/컴퓨터=보 비겼습니다');                
                break;
        }
    }
    if(cnt == 1){
        break;
    }
}