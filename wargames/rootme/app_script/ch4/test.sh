#!/bin/bash

wdir="cron.d/"
ls -1a "${wdir}" | while read task; do
	echo "${task}"
    if [ -f "${wdir}${task}" -a -x "${wdir}${task}" ]; then
		echo "${PWD}/${wdir}${task}"
        timelimit -q -s9 -S9 -t 5 bash -p "${PWD}/${wdir}${task}"
    fi
    rm -f "${PWD}/${wdir}${task}"
done
