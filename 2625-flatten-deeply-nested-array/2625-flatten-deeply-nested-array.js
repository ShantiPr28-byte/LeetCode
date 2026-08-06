/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {

    function dfs(array, depth) {
        let result = [];

        for(const element of array) {
            if(Array.isArray(element) && depth < n) {
                result.push(...dfs(element, depth + 1));
            } else {
                result.push(element);
            }
        }

        return result;
    }

    return dfs(arr, 0);
};