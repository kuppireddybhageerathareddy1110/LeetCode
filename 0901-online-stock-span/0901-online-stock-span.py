class StockSpanner:

    def __init__(self):

        # Stack stores:
        # (price, span)
        self.stack = []

    def next(self, price: int) -> int:

        # Today's span starts as 1
        span = 1

        # Remove smaller or equal prices
        while self.stack and self.stack[-1][0] <= price:

            # Add previous span
            span += self.stack.pop()[1]

            """
            Example:
            Current price = 75

            stack top:
            (60,1)

            pop it:
            span = 1 + 1 = 2

            next top:
            (70,2)

            pop it:
            span = 2 + 2 = 4
            """

        # Push current price and span
        self.stack.append((price, span))

        return span