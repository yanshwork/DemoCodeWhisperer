console.log(countingSort([5,4,3,2,1]));

//write code for radix sort
function radixSort(arr){
    let max = Math.max(...arr);
    let exp =1;
    while (max/exp >0 ){
        coutingSortByDigit (arr, exp);
        exp *=10;
    }
    return arr;
}

function coutingSortByDigit(arr, exp){
    let output = new Array(arr.length).fill(0);
    let count = new Array(10).fill(0);
    for (let i=0; i<arr.length; i++){
        count[(arr[i]/exp)%10]++;
    }
    for (let i=1; i<10; i++){
        count[i] += count[i-1];
    }
    for (let i=arr.length-1; i>=0; i--){
        output[count[(arr[i]/exp)%10]-1] = arr[i];
        count[(arr[i]/exp)%10]--;
    }
    for (let i=0; i<arr.length; i++){
        arr[i] = output[i];
    }
}