const actors = [
{ name: "David", lastName: "Bowie" },
{ name: "John", lastName: "Lennon" },
{ name: "Paul", lastName: "McCartney" }

];


// Sort the actors by age using the merge sort algorithm.
function mergeSort(array) {
    if (array.length <= 1) {
    return array;
  }

  const middle = Math.floor(array.length / 2);
  const left = array.slice(0, middle);
  const right = array.slice(middle);

  return merge(mergeSort(left), mergeSort(right));
}
function merge(left, right) {
    const result = [];
  while (left.length && right.length) {
    if (left[0] < right[0]) {
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
console.log(mergeSort(actors));

