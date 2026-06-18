class Solution {
  int maximalRectangle(List<List<String>> matrix) {
    
    int rows = matrix.length;
    int cols = matrix[0].length;

    List<int> heights = List.filled(cols, 0);
    int maxArea = 0;

    for (int i = 0; i < rows; i++) {

      // Build histogram
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == '1') {
          heights[j]++;
        } else {
          heights[j] = 0;
        }
      }

      // Largest Rectangle in Histogram
      List<int> stack = [];

      for (int j = 0; j <= cols; j++) {

        int currHeight = (j == cols) ? 0 : heights[j];

        while (
            stack.isNotEmpty &&
            heights[stack.last] >= currHeight) {

          int h = heights[stack.removeLast()];

          int width = stack.isEmpty
              ? j
              : j - stack.last - 1;

          maxArea = maxArea > h * width
              ? maxArea
              : h * width;
        }

        stack.add(j);
      }
    }

    return maxArea;
  }
}