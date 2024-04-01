package com.roblesdotdev.doa.onboarding.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.roblesdotdev.doa.core.presentation.DOAButton
import com.roblesdotdev.doa.core.presentation.DOATitle
import com.roblesdotdev.doa.onboarding.presentation.OnboardingPage
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingPager(modifier: Modifier = Modifier, pages: List<OnboardingPage>, onFinish: () -> Unit) {
    val pagerState = rememberPagerState {
        pages.size
    }
    val scope = rememberCoroutineScope()

    Box(modifier = modifier) {
        HorizontalPager(state = pagerState, modifier = modifier.fillMaxSize()) { page ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                DOATitle(text = pages[page].title)
                Spacer(modifier = Modifier.height(32.dp))
                Image(
                    painter = painterResource(id = pages[page].image),
                    contentDescription = null,
                    modifier = Modifier.aspectRatio(1f),
                    contentScale = ContentScale.FillHeight,
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = pages[page].subtitle.uppercase(),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Black),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.tertiary,
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(bottom = 48.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (pagerState.currentPage == pages.lastIndex) {
                DOAButton(text = "Get Started", onClick = onFinish)
            } else {
                TextButton(onClick = onFinish) {
                    Text("Skip", color = MaterialTheme.colorScheme.tertiary)
                }
                OnboardingPagerIndicator(pagerState = pagerState)
                TextButton(onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }) {
                    Text(text = "Next", color = MaterialTheme.colorScheme.tertiary)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingPagerIndicator(modifier: Modifier = Modifier, pagerState: PagerState) {
    Row(modifier = modifier) {
        repeat(pagerState.pageCount) { currentPage ->
            val alpha = if (pagerState.currentPage == currentPage) 1.0f else 0.3f
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary.copy(alpha = alpha))
            )
        }
    }
}
