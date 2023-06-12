const  actors = [ 
    { name: 'Tom Hanks', age: 56 },
    { name: 'Brad Pitt', age: 54 },
    { name: 'Angelina Jolie', age: 49 },
    { name: 'George Clooney', age: 44 },
    { name: 'Bradley Cooper', age: 41 }

];

// Sort the actors by age using the merge sort algorithm.
function mergeSort(arr) {
    if (arr.length < 2) {
        return arr;
    }
    const middle = Math.floor(arr.length / 2);
    const left = arr.slice(0, middle);
    const right = arr.slice(middle);
    return merge(mergeSort(left), mergeSort(right));
}
function merge(left, right) {
    const result = [];
    while (left.length && right.length) {
        if (left[0].age < right[0].age) {
            result.push(left.shift());
        } else {
            result.push(right.shift());
        }
    }
    while (left.length) {
        result.push(left.shift());
    }
    while (right.length) {
        result.push(right.shift());
    }
    return result;
}
const sortedActors = mergeSort(actors);
console.log(sortedActors);
