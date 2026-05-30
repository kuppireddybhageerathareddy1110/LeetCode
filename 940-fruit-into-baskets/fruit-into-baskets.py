class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        
        left = 0
        freq = {}
        max_fruits = 0
        
        for right in range(len(fruits)):
            
            # Add current fruit
            freq[fruits[right]] = freq.get(fruits[right], 0) + 1
            
            # If more than 2 fruit types, shrink window
            while len(freq) > 2:
                
                freq[fruits[left]] -= 1
                
                # Remove fruit type if count becomes 0
                if freq[fruits[left]] == 0:
                    del freq[fruits[left]]
                
                left += 1
            
            # Update maximum fruits collected
            max_fruits = max(max_fruits, right - left + 1)
        
        return max_fruits