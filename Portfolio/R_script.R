
plot(x=PriorityQData$N, y=PriorityQData$Count, xlab = "N ", ylab = "counts pr. N")
x <- PriorityQData$N
y <- PriorityQData$Count
mod <- lm(y~x,data = PriorityQData)
pre <-predict(mod)
line(pre)
?lm

